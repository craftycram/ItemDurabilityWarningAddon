package net.craftycram.durabilitywarningaddon;

import javassist.*;
import net.minecraft.item.ItemStack;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.ClassNode;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ItemStackDurabilityTransformer implements IClassTransformer {

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (name.equals("zx")) {
            try {
                ClassPool classPool = new ClassPool();
                classPool.appendClassPath(new LoaderClassPath(getClass().getClassLoader()));
                CtClass ctClass = classPool.makeClass(new ByteArrayInputStream(basicClass));

                ctClass.getDeclaredConstructor(classPool.get(new String[]{"zw", int.class.getName(), int.class.getName()})).insertAfter("{net.craftycram.durabilitywarningaddon.Test123.notify($0);}");

                ctClass.getDeclaredMethod("b", new CtClass[]{classPool.get("dn")}).insertAfter("{net.craftycram.durabilitywarningaddon.Test123.notify($0);}");
                return ctClass.toBytecode();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return basicClass;
    }

}
