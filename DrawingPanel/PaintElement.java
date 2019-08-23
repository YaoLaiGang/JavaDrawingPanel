
public class PaintElement {
	// startX, startY, mouseX, mouseY
	public Tool currentTool;
	public int startX;
	public int startY;
	public int mouseX;
	public int mouseY;
	public ToolDetails currenToolDetails;
	public PaintElement(Tool currentTool, int startX, int startY, int mouseX, int mouseY, ToolDetails currenToolDetails) {
		super();
		this.currentTool = currentTool;
		this.startX = startX;
		this.startY = startY;
		this.mouseX = mouseX;
		this.mouseY = mouseY;
		this.currenToolDetails = currenToolDetails;
	}
	
}
