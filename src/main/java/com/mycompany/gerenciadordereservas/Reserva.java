
package com.mycompany.gerenciadordereservas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.Exceptions.DomainException;


public class Reserva {
    
    private Integer numeroQuarto;
    private Date checkin;
    private Date checkout;
    
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroQuarto, Date checkin, Date checkout) {
        this.numeroQuarto = numeroQuarto;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getCheckin() {
        return checkin;
    }

    
    public Date getCheckout() {
        return checkout;
    }

    public long duracaoEstadia(){
        long duracao = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(duracao, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkin, Date checkout) throws DomainException{
        Date now = new Date();
        
        if(checkin.before(now) || checkout.before(now)){
            throw new DomainException("As novas datas da reserva precisam ser datas futuras");
        }
        
        if(!checkout.after(checkin)){
            throw new DomainException("A nova data de checkout precisa ser posterior ao checkin");
        }
        
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Reserva{" + "numeroQuarto=" + numeroQuarto + ", checkin=" + sdf.format(checkin) + ", checkout=" + sdf.format(checkout) + '}';
    }
    
    
    
}
