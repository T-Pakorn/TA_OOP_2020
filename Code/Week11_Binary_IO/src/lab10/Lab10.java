/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Lab10 extends Application{


  private TextField tfAnnualInterestRate = new TextField();
  private TextField tfNumberOfYears = new TextField();
  private TextField tfLoanAmount = new TextField();
  private TextField tfMonthlyPayment = new TextField();
  private TextField tfTotalPayment = new TextField();
  private Button btnCalculate = new Button("Calculate");
  
  //More button for Lab10
  private Button btnClear = new Button("Clear");
  private Button btnSave = new Button("Save");
  private Button btnLoad = new Button("Load");
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create UI
    GridPane gridPane = new GridPane();
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    gridPane.add(new Label("Annual Interest Rate:"), 0, 0);
    gridPane.add(tfAnnualInterestRate, 1, 0);
    gridPane.add(new Label("Number of Years:"), 0, 1);
    gridPane.add(tfNumberOfYears, 1, 1);
    gridPane.add(new Label("Loan Amount:"), 0, 2);
    gridPane.add(tfLoanAmount, 1, 2);
    gridPane.add(new Label("Monthly Payment:"), 0, 3);
    gridPane.add(tfMonthlyPayment, 1, 3);
    gridPane.add(new Label("Total Payment:"), 0, 4);
    gridPane.add(tfTotalPayment, 1, 4);
    
    HBox rightBtnGroup = new HBox(10);
    rightBtnGroup.getChildren().add(btnClear);
    rightBtnGroup.getChildren().add(btnCalculate);
    rightBtnGroup.setAlignment(Pos.CENTER);
    gridPane.add(rightBtnGroup, 1, 5);
    HBox leftBtnGroup = new HBox(10);
    leftBtnGroup.getChildren().add(btnSave);
    leftBtnGroup.getChildren().add(btnLoad);
    leftBtnGroup.setAlignment(Pos.CENTER);
    gridPane.add(leftBtnGroup,0,5);

    // Set properties for UI
    gridPane.setAlignment(Pos.CENTER);
    tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
    tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
    tfLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
    tfMonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
    tfTotalPayment.setAlignment(Pos.BOTTOM_RIGHT);
    tfMonthlyPayment.setEditable(false);
    tfTotalPayment.setEditable(false);
    GridPane.setHalignment(btnCalculate, HPos.RIGHT);

    // Process events
    btnCalculate.setOnAction(e -> calculateLoanPayment());
    btnClear.setOnAction(eh->{
        tfAnnualInterestRate.setText("");
        tfNumberOfYears.setText("");
        tfLoanAmount.setText("");
        tfMonthlyPayment.setText("");
        tfTotalPayment.setText("");
    });
    btnSave.setOnAction(eh->{
        try (ObjectOutputStream loanWriter = new ObjectOutputStream(new FileOutputStream("loan.dat"))){
            double interest =Double.parseDouble(tfAnnualInterestRate.getText());
            int year = Integer.parseInt(tfNumberOfYears.getText());
            double loanAmount =Double.parseDouble(tfLoanAmount.getText());
            loanWriter.writeObject(new Loan(interest,year,loanAmount));
            System.out.println("File saved successfully");
        } catch (IOException ex) {
            System.err.println("File saving failed");
        }
    });
    btnLoad.setOnAction(eh->{
        try (ObjectInputStream loanReader = new ObjectInputStream(new FileInputStream("loan.dat"))){
            Loan readLoan = (Loan)loanReader.readObject();
            tfAnnualInterestRate.setText(String.valueOf(readLoan.getAnnualInterestRate()));
            tfNumberOfYears.setText(String.valueOf(readLoan.getNumberOfYears()));
            tfLoanAmount.setText(String.valueOf(readLoan.getLoanAmount()));
            tfMonthlyPayment.setText("");
            tfTotalPayment.setText("");
            System.out.println("File read successfully");
        } catch (FileNotFoundException ex) {
            System.err.println("File reading failed");
        } catch (IOException ex) {
            Logger.getLogger(Lab10.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Lab10.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    });

    // Create a scene and place it in the stage
    Scene scene = new Scene(gridPane, 400, 250);
    primaryStage.setTitle("LoanCalculator"); // Set title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  
  private void calculateLoanPayment() {
    // Get values from text fields
    double interest =
      Double.parseDouble(tfAnnualInterestRate.getText());
    int year = Integer.parseInt(tfNumberOfYears.getText());
    double loanAmount =
      Double.parseDouble(tfLoanAmount.getText());

    // Create a loan object. Loan defined in Listing 10.2
    Loan loan = new Loan(interest, year, loanAmount);

    // Display monthly payment and total payment
    tfMonthlyPayment.setText(String.format("$%.2f",
      loan.getMonthlyPayment()));
    tfTotalPayment.setText(String.format("$%.2f",
      loan.getTotalPayment()));
  }

  public static void main(String[] args) {
    launch(args);
  }
    
}
