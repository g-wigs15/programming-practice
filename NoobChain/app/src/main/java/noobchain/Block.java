package noobchain;
import java.util.Date;

public class Block {
    
    public String hash;
	public String previousHash;
	private String data; //our data will be a simple message.
	private final long timeStamp; 
    private int n; // was called nonce, but I dont like british terms (YUCK)

    // Constructor for Block Class
    public Block(String data,String previousHash ) {
		
        this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); 
	}

    // Calls the Sha256 from StringUtil to create a hash for the Block Object in the main method.
    public String calculateHash(){
        
        String calculatedhash = StringUtil.applySha256( 
			
            previousHash + Long.toString(timeStamp) + Integer.toString(n) + data 
		);

	return calculatedhash;
    }

    // 
    public void mineBlock(int diff){
        
        String target = new String(new char[diff]).replace('\0', '0');//Create a string with difficulty * "0" 
        
        while(!hash.substring( 0, diff).equals(target)) {
			n++;
			hash = calculateHash();
		}
		
        System.out.println("Block Mined!!! : " + hash);
    }
}
