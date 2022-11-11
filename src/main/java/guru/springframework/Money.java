package guru.springframework;

public class Money implements Expression {

  protected int amount;
  protected String currency;

  protected String currency() {
    return currency;
  };

  public Money times(int multiplier) {
    return new Money(amount * multiplier, currency);
  };

  public Money(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  @Override
  public boolean equals(Object object) {
    Money money = (Money) object;
    return amount == money.amount && this.currency.equals(money.currency);
  }

  public static Money dollar(int amount) {
    return new Money(amount, "USD");
  }

  public static Money franc(int amount) {
    return new Money(amount, "CHF");
  }

  public Money reduce(String to) {
    return this;
  }

  @Override
  public String toString() {
    return "Money [amount=" + amount + ", currency=" + currency + "]";
  }

  public Expression plus(Money addend) {
    return new Sum(this, addend);
  }

}
