/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bayesnet;

/**
 *
 * @author Kenneth
 */
import JavaBayesInterface.*;
import InferenceGraphs.*;

public class JavaBayes{
  // Graphical elements of JavaBayes
  EditorFrame editorFrame;
  JavaBayesConsoleFrame consoleFrame;

  // Applet flags
  public boolean is_applet = false;
  
  /**
   * Main method for JavaBayes.
   */
  public static void main(String argv[]) {
    JavaBayes jb = new JavaBayes();
    jb.construct(false);
    if (argv.length > 0) {
        String filename = argv[0];
        System.out.println(filename);
        jb.open(filename);
    }
  }

  /*
   * Do all the initializations for a JavaBayes object. 
   */
  private void construct(boolean ia) {
    is_applet = ia;

    editorFrame = new EditorFrame(this, "BayesNet Editor");
    editorFrame.show();
    consoleFrame = new JavaBayesConsoleFrame(this, "BayesNet Console");
    consoleFrame.show();

    JavaBayesHelpMessages.insert(this);
    JavaBayesHelpMessages.show(JavaBayesHelpMessages.about_message);
    JavaBayesHelpMessages.show(JavaBayesHelpMessages.start_message);
  }

  /**
   * Open a file and read the network in it. 
   */
  public boolean open(String filename) {
    return( editorFrame.open(filename) );
  }

  /**
   * Open a URL and read the network in it.
   */
  public boolean open_url(String filename) {
    return( editorFrame.open_url(filename) );
  }

  /**
   * Clear the network.
   */
  public void clear() {
    editorFrame.clear();
    set_current_save_filename(null);
  }

  /**
   * Save the network.
   */
  public boolean save() {
    return(editorFrame.save()); 
  } 

  /**
   * Save the network.
   */
  public boolean save(String filename) {
    return(editorFrame.save(filename));
  }

  /**
   * Interact with menu options: whether to show BucketTree.
   */
  public void what_to_show_bucket_tree_action(boolean what_to_show_bucket_tree) {
        editorFrame.what_to_show_bucket_tree_action(what_to_show_bucket_tree);
  }

  /**
   * Interact with menu options: whether to show bayesian networks.                                                *
   */
  public void what_to_show_bayesian_network_action(boolean what_to_show_bayesian_network) {
        editorFrame.what_to_show_bayesian_network_action(what_to_show_bayesian_network);
  }

 /**
   * Inferences produce expectations.   
   */
  public void posterior_expectation_action() {
        editorFrame.posterior_expectation_action();
  }

  /**
   * Inferences produce posterior marginals.
   */
  public void posterior_marginal_action() {
        editorFrame.posterior_marginal_action();
  }

  /**
   * Estimate explanation variables.
   */
  public void estimate_explanation_variables_action() {
        editorFrame.estimate_explanation_variables_action();
  }

  /**
   * Produce the estimates for the best configuration.     
   */
  public void estimate_best_configuration_action() {
        editorFrame.estimate_best_configuration_action();
  }

  /**
   * Produce sensitivity analysis.
   */
  public void sensitivity_analysis_action() {
        editorFrame.sensitivity_analysis_action();  
  }
  
  /**
   * Use bif format for saving.  
   */
  public void bif_format_action() {
        editorFrame.set_save_format(EditorFrame.BIF_FORMAT);
  }

  /**
   * Use xml format for saving. 
   */
  public void xml_format_action() {
        editorFrame.set_save_format(EditorFrame.XML_FORMAT);
  }

  /**
   * Use bugs format for saving.
   */
  public void bugs_format_action() {
        editorFrame.set_save_format(EditorFrame.BUGS_FORMAT);
  }

  /**
   * Quit gracefully.
   */
  public void quit() {

		System.exit(0);
  }

  /**
   * Put text in the consoleFrame.
   */
  public void appendText(String s) {
    consoleFrame.appendText(s);
  }
  
  /**
   * Get the current filename for saving.
   */
  public String get_current_save_filename() {
    return( editorFrame.get_current_save_filename() );
  }
  
  /**
   * Set the current filename for saving.
   */
  public void set_current_save_filename(String filename) {
    editorFrame.set_current_save_filename(filename);
  }
  
  /**
   * Set the inference algorithm as variable elimination.
   */
  public void set_algorithm_variable_elimination() {
    editorFrame.set_algorithm(EditorFrame.ALGORITHM_VARIABLE_ELIMINATION);
  }

  
  /**
   * Set the inference algorithm as bucket tree.
   */
  public void set_algorithm_bucket_tree() {
    editorFrame.set_algorithm(EditorFrame.ALGORITHM_BUCKET_TREE);
  }
}
