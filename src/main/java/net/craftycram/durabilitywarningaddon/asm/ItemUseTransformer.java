package net.craftycram.durabilitywarningaddon.asm;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;


public class ItemUseTransformer extends PredicateClassNodeTransformer {

    @Override
    public void transform(String name, String transformedName, ClassNode node) {
        node.methods.stream()
                .filter((methodNode) -> methodNode.name.equals("a") && methodNode.desc.equals("(CI)V"))
                .findFirst()
                .ifPresent((methodNode) -> {
                    InsnList list = new InsnList();

                    //list.add(new VarInsnNode(Opcodes.ILOAD, 1));
                    //list.add(new VarInsnNode(Opcodes.ILOAD, 2));
                    list.add(new MethodInsnNode(Opcodes.INVOKESTATIC, "net/craftycram/durabilitywarningaddon", "test", "(CI)Z", false));


                    methodNode.instructions.insert(methodNode.instructions.getFirst(), list);
                });
    }

    @Override
    public boolean transforms(String name, String transformedName, byte[] basicClass) {
        return name.startsWith("net.labymod.ingamechat.tabs")
                || transformedName.startsWith("net.labymod.ingamechat.tabs");
    }
    // net.minecraftforge.event.entity.player.PlayerInteractEvent

}
