package com.transaction.service;

import com.transaction.model.Transaction;
import com.transaction.repository.TransactionRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    private TransactionRepository transactionRepository;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        List<Transaction> transactions = transactionRepository.findAll();
        File file = ResourceUtils.getFile("classpath:reportTransaction.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(transactions);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Tseku");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, "/Users/tsenguunotgonbaatar/Dev/golomt/transactions_report.html");
            return "html generated";
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, "/Users/tsenguunotgonbaatar/Dev/golomt/transactions_report.pdf");
            return "pdf generated";
        }
        return "report generated";
    }
}
