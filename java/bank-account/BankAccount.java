/**
 * Bank Account
 * https://exercism.org/tracks/java/exercises/bank-account
 */
public class BankAccount {

    private boolean active;
    private int balance;

    public synchronized void open() {
        active = true;
    }

    public synchronized void close() {
        active = false;
    }

    public synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        if (!active) {
            throw new BankAccountActionInvalidException("Account closed");
        }

        if (amount < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }

        balance += amount;
    }

    public synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
        if (!active) {
            throw new BankAccountActionInvalidException("Account closed");
        }

        if (amount < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }

        if (balance == 0) {
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        }

        if (balance < amount) {
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        }

        balance -= amount;
    }

    public synchronized int getBalance() throws BankAccountActionInvalidException {
        if (!active) {
            throw new BankAccountActionInvalidException("Account closed");
        }

        return balance;
    }
}
