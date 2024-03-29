package com.bcopstein;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class PersistenciaPassageiro {
    private static final String nArq = ".\\resources\\passageiros.dat";

    public static List<Passageiro> carregaPassageiros() {
        List<Passageiro> passageiros = new LinkedList<>();

        String currDir = Paths.get("").toAbsolutePath().toString();
        String caminhoCompleto = currDir + "\\" + nArq;
        Path refArq = Paths.get(caminhoCompleto);

        //cpf,nome,formaPgto,nroCartao,pontuacaoAcumulada,qtdadeAvaliacoes
        try {
            Reader reader = Files.newBufferedReader(refArq);
            // CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            for (CSVRecord csvRecord : csvRecords) {
                String cpf = csvRecord.get("cpf");
                String nome = csvRecord.get("nome");
                FormaPagamento formaPagto = FormaPagamento.valueOf(csvRecord.get("formaPgto"));
                String nroCartao = csvRecord.get("nroCartao");
                int pontuacaoAcumulada = Integer.parseInt(csvRecord.get("pontuacaoAcumulada"));
                int qtdadeAvaliacoes = Integer.parseInt(csvRecord.get("qtdadeAvaliacoes"));
                Passageiro passageiro = new Passageiro(cpf,nome,formaPagto,nroCartao,pontuacaoAcumulada,qtdadeAvaliacoes);
                passageiros.add(passageiro);
            }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
            return null;
        }
        return passageiros;
    }

    public static boolean persistePassageiros(List<Passageiro> passageiros){
        Path path = Paths.get(nArq); 
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, Charset.defaultCharset()))){ 
            writer.println("cpf,nome,formaPgto,nroCartao,pontuacaoAcumulada,qtdadeAvaliacoes");
            for(Passageiro p:passageiros) 
                writer.format(Locale.ENGLISH,
                              "%s,%s,%s,%s,%d,%d\n",
                              p.getCPF(),p.getNome(),p.getFormaPgto().toString(),
                              p.getNroCartao(),p.getPontuacaoAcumulada(),
                              p.getQtdadeAvaliacoes());
        } 
        catch (IOException x) { 
            System.err.format("Erro de E/S: %s%n", x); 
            return false;
        } 
        return true;
    }
}