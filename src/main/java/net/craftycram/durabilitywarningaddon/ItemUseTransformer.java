package net.craftycram.durabilitywarningaddon;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.tree.ClassNode;
import net.minecraft.launchwrapper.IClassTransformer;

import java.util.Arrays;

public class ItemUseTransformer implements IClassTransformer {

    private static final String[] classesBeingTransformed = {
            "net.minecraftforge.event.entity.player.PlayerUseItemEvent"
    };

    @Override
    public byte[] transform(String name, String transformedName, byte[] classBeingTransformed) {

        boolean isObfuscated = !name.equals(transformedName);
        int index = Arrays.asList(classBeingTransformed).indexOf(transformedName);
        return index != -1 ? transform(index, classBeingTransformed, isObfuscated): classBeingTransformed;
    }

    public static byte[] transform(int index, byte[] classBeingTransformed, boolean isObfuscated) {

        System.out.println("Transforming: " + classesBeingTransformed[index]);
        try {
            ClassNode classNode = new ClassNode();
            ClassReader classReader = new ClassReader(classBeingTransformed);
            classReader.accept(classNode, 0);

            switch (index) {
                case 0:
                    transformItemUse(classNode, isObfuscated);
                    break;
            }

            ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
            classNode.accept(classWriter);
            return classWriter.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return classBeingTransformed;

    }

    public static void transformItemUse(ClassNode itemUseClass, boolean isObfuscated) {



    }
}
