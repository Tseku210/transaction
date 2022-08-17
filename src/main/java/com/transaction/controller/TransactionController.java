package com.transaction.controller;

import com.transaction.model.Transaction;
import com.transaction.service.ReportService;
import com.transaction.service.TransactionService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="/api")
public class TransactionController {
    @Autowired
    private TransactionService service;
    @Autowired
    private ReportService reportService;

    @PostMapping("/add")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return service.saveTransaction(transaction);
    }
//    @PostMapping("/add")
//    public @ResponseBody String addTransaction(@RequestParam String userDans, @RequestParam String receiverDans, @RequestParam String amount, @RequestParam String type) {
//        double amnt =Double.parseDouble(amount);
//        return service.saveTransaction(userDans, receiverDans, amnt, type);
//    }

//    @PostMapping("/addTransactions")
//    public List<Transaction> addTransactions(@RequestBody List<Transaction> transactions) {
//        return service.saveTransactions(transactions);
//    }
    @GetMapping("/all")
    public @ResponseBody List<Transaction> findAllTransactions() {
        return service.getAllTransactions();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable int id) {
        return service.deleteTransaction(id);
    }
    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
        return reportService.exportReport(format);
    }
}
