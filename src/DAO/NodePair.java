package DAO;

public class NodePair {
	int srcNode;
	int destNode;
	@Override
	public String toString() {
		return "Connection [srcNode=" + srcNode + ", destNode=" + destNode
				+ "]";
	}
	public int getSrcNode() {
		return srcNode;
	}
	public void setSrcNode(int srcNode) {
		this.srcNode = srcNode;
	}
	public int getDestNode() {
		return destNode;
	}
	public void setDestNode(int destNode) {
		this.destNode = destNode;
	}
	public NodePair(int srcNode, int destNode) {
		this.srcNode = srcNode;
		this.destNode = destNode;
	}

}
