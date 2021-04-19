import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class NoobChain {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 3;

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("current hashes are not equal");
                return false;
            }
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("previous hashes are not equal");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        blockchain.add(new Block("hi i am the first block", "0"));
        System.out.println("trying to mine block 1...");
        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(new Block("hi i am the second block", blockchain.get(blockchain.size() - 1).hash));
        System.out.println("trying to mine block 2 .....");
        blockchain.get(1).mineBlock(difficulty);

        blockchain.add(new Block("hi am the third block", blockchain.get(blockchain.size() - 1).hash));
        System.out.println("trying to mine block 3.......");
        blockchain.get(2).mineBlock(difficulty);

        System.out.println("\n Blockchain is valid : " + isChainValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\n The block chain :");
        System.out.println(blockchainJson);
    }
}
