package service;

import model.Calculation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Stateless
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalculationService {

    @PersistenceContext(unitName = "CalcDB")
    private EntityManager entityManager;

    @POST
    @Path("/calc")
    public String createCalculation(Calculation calculation) {
        try {
            double result = calculation.calculate();
            entityManager.persist(calculation);
            return "Result: " + result;
        } catch (Exception e) {
            throw new RuntimeException("Internal Server Error");
        }
    }
    
    @GET
    @Path("/calculations")
    public List<Calculation> getAllCalculations() {
        try {
            List<Calculation> calculations = entityManager.createQuery("SELECT c FROM Calculation c", Calculation.class).getResultList();
            return calculations;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    
}
