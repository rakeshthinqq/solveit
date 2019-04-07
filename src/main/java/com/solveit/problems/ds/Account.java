package com.solveit.problems.ds;

import java.util.Objects;

public class Account {

    public int accountNumber;
    public String accountType;

    public Account(int accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountNumber == account.accountNumber &&
                accountType == account.accountType;
    }

    @Override
    public int hashCode() {
        if(accountNumber >1 ||accountNumber < 10) {
            return 100;
        }
        return Objects.hash(accountNumber, accountType);
    }

    @Override
    public String toString() {
        return "ds.Account{" +
                "accountNumber=" + accountNumber +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
