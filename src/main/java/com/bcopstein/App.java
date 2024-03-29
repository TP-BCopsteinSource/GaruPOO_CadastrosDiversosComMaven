package com.bcopstein;

import java.util.List;

public class App {
    public static void main(String args[]){
        List<Veiculo> veiculos;

        System.out.println("Veiculos:");
        veiculos = PersistenciaVeiculos.carregaVeiculos();
        veiculos.forEach(v->System.out.println(v));

        List<Passageiro> passageiros;
        System.out.println("\nPassageiros:");
        passageiros = PersistenciaPassageiro.carregaPassageiros();
        passageiros.forEach(p->System.out.println(p));

        List<Motorista> motoristas;
        System.out.println("\nMotoristas:");
        motoristas = PersistenciaMotoristas.carregaMotoristas();
        motoristas.forEach(m->System.out.println(m));

        /*
        veiculos.add(new Veiculo("WQY8J833","PORSHE","PRETO",Veiculo.CategoriaVeiculo.LUXO));
        PersistenciaVeiculos.persisteVeiculos(veiculos);
        veiculos = PersistenciaVeiculos.carregaVeiculos();
        System.out.println("\nNovos veiculos:");
        veiculos.forEach(v->System.out.println(v));

        passageiros.add(new Passageiro("9857643899","MINIE",FormaPagamento.CARTAO,"876098267",10,2));
        PersistenciaPassageiro.persistePassageiros(passageiros);
        passageiros = PersistenciaPassageiro.carregaPassageiros();
        System.out.println("\nNova lista de passageiros:");
        passageiros.forEach(p->System.out.println(p));
        
        motoristas.add(new Motorista("9587865440","Ana Lucia","WQY8J833",FormaPagamento.CARTAO,55,14));
        PersistenciaMotoristas.persisteMotoristas(motoristas);
        motoristas = PersistenciaMotoristas.carregaMotoristas();
        System.out.println("\nNova lista de Motoristas:");
        motoristas.forEach(m->System.out.println(m));
        */
    }
}
/*
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
*/
/*
Usando o apache commons cvs sem maven
Extrair o arquivo commons-csv-1.7.jar para o diretorio do projeto
Para compilar no Windows: javac -cp .;.\commons-csv-1.7.jar App.java
Para compilar no Linux: javac -cp commons-csv-1.7.jar App.java

Para executar: java -cp .;.\commons-csv-1.7.jar App.java
*/
/*
public class App {
    private static final String SAMPLE_CSV_FILE_PATH = "veiculos.dat";

    public static void main(String[] args) throws IOException {
        try (
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String placa = csvRecord.get(0);
                String marca = csvRecord.get(1);
                String cor = csvRecord.get(2);
                String categoria = csvRecord.get(3);

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Placa : " + placa);
                System.out.println("Marca : " + marca);
                System.out.println("Cor : " + cor);
                System.out.println("Categoria : " + categoria);
                System.out.println("---------------\n\n");
            }
        }
    }
}
*/