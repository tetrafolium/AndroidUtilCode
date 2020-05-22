package com.blankj.bus;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2019/07/09
 *     desc  :
 * </pre>
 */
public class BusClassVisitor extends ClassVisitor {

    private Map<String, List<BusInfo>> mBusMap;

    private String  className;
    private BusInfo busInfo;
    private String  tag;
    private String  funParamDesc;
    private String  mBusUtilsClass;
    private boolean isStartVisitParams;

    public BusClassVisitor(final ClassVisitor classVisitor, final Map<String, List<BusInfo>> busMap, final String busUtilsClass) {
        super(Opcodes.ASM5, classVisitor);
        mBusMap = busMap;
        mBusUtilsClass = busUtilsClass.replace(".", "/");
    }

    @Override
    public void visit(final int version, final int access, final String name, final String signature, final String superName, final String[] interfaces) {
        className = name.replace("/", ".");
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(final int access, final String funName, final String desc, final String signature, final String[] exceptions) {
        if (cv == null) return null;
        MethodVisitor mv = cv.visitMethod(access, funName, desc, signature, exceptions);
        busInfo = null;
        isStartVisitParams = false;
        mv = new AdviceAdapter(Opcodes.ASM5, mv, access, funName, desc) {
            @Override
            public AnnotationVisitor visitAnnotation(final String desc1, final boolean visible) {
                final AnnotationVisitor av = super.visitAnnotation(desc1, visible);
                if (("L" + mBusUtilsClass + "$Bus;").equals(desc1)) {
                    busInfo = new BusInfo(className, funName);
                    funParamDesc = desc.substring(1, desc.indexOf(")"));
                    return new AnnotationVisitor(Opcodes.ASM5, av) {
                        @Override
                        public void visit(final String name, final Object value) { // 可获取注解的值
                            super.visit(name, value);
                            if ("tag".equals(name)) {
                                tag = (String) value;
                            } else if ("sticky".equals(name) && (Boolean) value) {
                                busInfo.sticky = true;
                            } else if ("priority".equals(name)) {
                                busInfo.priority = (int) value;
                            }
                        }

                        @Override
                        public void visitEnum(final String name, final String desc, final String value) {
                            super.visitEnum(name, desc, value);
                            if ("threadMode".equals(name)) {
                                busInfo.threadMode = value;
                            }
                        }
                    };
                }
                return av;
            }

            @Override
            public void visitLocalVariable(final String name, final String desc, final String signature, final Label start, final Label end, final int index) {
                super.visitLocalVariable(name, desc, signature, start, end, index); // 获取方法参数信息
                if (busInfo != null && !funParamDesc.equals("")) {
                    if (!isStartVisitParams && index != 0) {
                        return;
                    }
                    isStartVisitParams = true;
                    if ("this".equals(name)) {
                        return;
                    }
                    funParamDesc = funParamDesc.substring(desc.length()); // 每次去除参数直到为 ""，那么之后的就不是参数了
                    busInfo.paramsInfo.add(new BusInfo.ParamsInfo(Type.getType(desc).getClassName(), name));
                    if (busInfo.isParamSizeNoMoreThanOne && busInfo.paramsInfo.size() > 1) {
                        busInfo.isParamSizeNoMoreThanOne = false;
                    }
                }
            }

            @Override
            public void visitEnd() {
                super.visitEnd();
                if (busInfo != null) {
                    List<BusInfo> infoList = mBusMap.get(tag);
                    if (infoList == null) {
                        infoList = new ArrayList<>();
                        mBusMap.put(tag, infoList);
                    }
                    infoList.add(busInfo);
                }
            }
        };

        return mv;
    }
}
