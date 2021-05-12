
package com.mycompany.gerenciadordereservas;

import java.text.ParseException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Exceptions.DomainException;

public class Programa {

    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            System.out.print("Número do quarto:");
            int quarto = teclado.nextInt();
            System.out.print("Data de checkin: ");
            Date checkin = sdf.parse(teclado.next());
            System.out.print("Data do checkout: ");
            Date checkout = sdf.parse(teclado.next());
            
            Reserva nova = new Reserva(quarto, checkin, checkout);
            System.out.println("Reserve: " + nova);
            
            System.out.println("");
            System.out.println("Informe a nova data para atualização da reserva: ");
            System.out.print("Nova Data de Checkin: ");
            checkin = sdf.parse(teclado.next());
            System.out.println("Nova Data de Checkout: ");
            checkout = sdf.parse(teclado.next());
            
            nova.updateDates(checkin, checkout);
            System.out.println("Reserva Atualizada: "+ nova);
        }
        catch(ParseException e){
            System.out.println("Erro ao inserir as datas");
        }
        catch(DomainException e){
            System.out.println(e.getMessage());
        }
        
        teclado.close();
    }
    
}
