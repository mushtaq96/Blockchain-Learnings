public class NoobChain {
    public static void main(String[] args) {
        Block genesisBlock = new Block("hi i am the first block", "0");
        System.out.println("Hash for block 1 : " + genesisBlock.hash);

        Block secondBlock = new Block("hi i am the second block", genesisBlock.hash);
        System.out.println("hash for block 2 : " + secondBlock.hash);

        Block thirdBlock = new Block("hi am the third block", secondBlock.hash);
        System.out.println("hash for block 3 : " + thirdBlock.hash);
    }
}
