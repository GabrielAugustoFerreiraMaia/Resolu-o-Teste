import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Exerc_03 {

    public static void main(String[] args) {
        
        
        JSONArray faturamento = null;
        try {
            JSONParser parser = new JSONParser();
            faturamento = (JSONArray) parser.parse(new FileReader("faturamento.json"));
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo JSON: " + e.getMessage());
            System.exit(1);
        }
        
        
        double menorFaturamento = Double.MAX_VALUE;
        for (Object obj : faturamento) {
            JSONObject dia = (JSONObject) obj;
            double valor = Double.parseDouble(dia.get("valor").toString());
            if (valor < menorFaturamento) {
                menorFaturamento = valor;
            }
        }
        
        
        double maiorFaturamento = Double.MIN_VALUE;
        for (Object obj : faturamento) {
            JSONObject dia = (JSONObject) obj;
            double valor = Double.parseDouble(dia.get("valor").toString());
            if (valor > maiorFaturamento) {
                maiorFaturamento = valor;
            }
        }
        
        
        double somaFaturamento = 0.0;
        int numDiasFaturamento = 0;
        for (Object obj : faturamento) {
            JSONObject dia = (JSONObject) obj;
            double valor = Double.parseDouble(dia.get("valor").toString());
            String tipo = dia.get("tipo").toString();
            if (tipo.equals("util")) {
                somaFaturamento += valor;
                numDiasFaturamento++;
            }
        }
        double mediaFaturamento = somaFaturamento / numDiasFaturamento;
        
        
        int numDiasAcimaMedia = 0;
        for (Object obj : faturamento) {
            JSONObject dia = (JSONObject) obj;
            double valor = Double.parseDouble(dia.get("valor").toString());
            String tipo = dia.get("tipo").toString();
            if (tipo.equals("util") && valor > mediaFaturamento) {
                numDiasAcimaMedia++;
            }
        }
        
        
        System.out.printf("Menor faturamento: R$ %.2f\n", menorFaturamento);
        System.out.printf("Maior faturamento: R$ %.2f\n", maiorFaturamento);
        System.out.println("Número de dias com faturamento acima da média mensal: " + numDiasAcimaMedia);
    }