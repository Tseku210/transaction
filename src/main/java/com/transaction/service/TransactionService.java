package com.transaction.service;

import com.transaction.model.Transaction;
import com.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
//    public List<Transaction> saveTransactions(List<Transaction> transactions) {
//        return transactionRepository.saveAll(transactions);
//    }
//    public String saveTransaction(String userDans, String receiverDans, double amount,  String type) {
//        Transaction t = new Transaction();
//        t.setUserDans(userDans);
//        t.setReceiverDans(receiverDans);
//        t.setAmount(amount);
//        t.setType(type);
//        LocalDate date = LocalDate.now();
//        t.setDate(date);
//        transactionRepository.save(t);
//        return "SAVED";
//    }
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
//    public List<Transaction> getTransactions() {
//        return transactionRepository.findAll();
//    }
    public Transaction getTransactionById(int id) {
        return transactionRepository.findById(id).orElse(null);
    }
//    public Transaction getTransactionByName(String name) {
//        return transactionRepository.findByName(name);
//    }
    public String deleteTransaction(int id) {
        transactionRepository.deleteById(id);
        return "transaction deleted " + id;
    }
}
