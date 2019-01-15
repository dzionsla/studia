import java.util.*;

public class BankAccountBusinessCard extends BusinessCardO{
  private String bankAccount; // bo za duza liczba na int albo dint

  // Konstruktory
  public BankAccountBusinessCard(String name, String surname, int phone, String city, String bankAccount){
    super(name, surname, phone, city);
    this.bankAccount = bankAccount;
  }

  // Settery
  public void setBankAccount(String bankAccount){
    this.bankAccount = bankAccount;
  }
  // Gettery
  public String getBankAccount(){
    return bankAccount;
  }

  protected ArrayList<String> getLines() {
      ArrayList<String> lines = super.getLines();
      lines.add("nr " + bankAccount);
      return lines;
  }

}
