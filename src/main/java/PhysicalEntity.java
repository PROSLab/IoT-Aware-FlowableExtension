import org.activiti.designer.integration.DiagramBaseShape;
import org.activiti.designer.integration.annotation.Help;
import org.activiti.designer.integration.annotation.Property;
import org.activiti.designer.integration.servicetask.AbstractCustomServiceTask;
import org.activiti.designer.integration.servicetask.PropertyType;
import org.activiti.designer.integration.annotation.Runtime;

/**
 * @author Ivan Compagnucci
 * @version 1
 * @since 1.0.0
 */
@Runtime(javaDelegateClass = "org.acme.runtime.AcmeMoneyJavaDelegation")
@Help(displayHelpShort = "Creates a new account", displayHelpLong =
    "Creates a new account using the account number specified")
public class PhysicalEntity extends AbstractCustomServiceTask {

  private static final String HELP_ACCOUNT_NUMBER_LONG =
      "Provide a number that is suitable as an account number.";

  @Property(type = PropertyType.TEXT, displayName = "Account Number", required = true)
  @Help(displayHelpShort = "Provide an account number", displayHelpLong = HELP_ACCOUNT_NUMBER_LONG)
  private String accountNumber;

  @Property(type = PropertyType.MULTILINE_TEXT, displayName = "Comments")
  @Help(displayHelpShort = "Provide comments", displayHelpLong =
      "You can add comments to the node to provide a brief description.")
  private String comments;

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
	  return DiagramBaseShape.EVENT;
  }

  @Override
  public String getSmallIconPath() {
    return "";
  }
  
  @Override
  public String getShapeIconPath() {
    return "";
  }
  
  @Override
  public String getLargeIconPath() {
    return "";
  }
 
}