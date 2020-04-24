import org.activiti.designer.integration.DiagramBaseShape;
import org.activiti.designer.integration.annotation.Help;
import org.activiti.designer.integration.annotation.Property;
import org.activiti.designer.integration.annotation.PropertyItems;
import org.activiti.designer.integration.servicetask.AbstractCustomServiceTask;
import org.activiti.designer.integration.servicetask.PropertyType;
import org.activiti.designer.integration.annotation.Runtime;

/**
 * @author Ivan Compagnucci
 * @version 1
 * @since 1.0.0
 */
@Runtime(javaDelegateClass = "delegateClasses.physicalEntityDelegate")
@Help(displayHelpShort = "This is the Physical Entity", displayHelpLong =
    "This is a representation of a specific device or thing in the real world that interact with the process")
public class PhysicalEntity extends AbstractCustomServiceTask {
  
	@Property(type = PropertyType.TEXT, displayName = "Physical Entity Name", required = true)
	  @Help(displayHelpShort = "Provide the name of the physical entity", displayHelpLong = "Insert the name of the physical entity")
	  private String physicalEntityName;

  @Override
  public String contributeToPaletteDrawer() {
    return "IoT-Aware Extensions";
  }

  @Override
  public String getName() {
    return "Physical Entity ";
  }

  @Override
  public DiagramBaseShape getDiagramBaseShape() {
	  return DiagramBaseShape.ACTIVITY;
  }

  @Override
  public String getSmallIconPath() {
    return "icons/physicalEntity.png";
  }
  
  @Override
  public String getShapeIconPath() {
    return "icons/physicalEntity.png";
  }
  
  @Override
  public String getLargeIconPath() {
    return "icons/physicalEntity.png";
  }
 
}