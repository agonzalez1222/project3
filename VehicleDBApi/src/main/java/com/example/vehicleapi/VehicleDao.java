package com.example.vehicleapi;

import ch.qos.logback.core.pattern.color.GreenCompositeConverter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class VehicleDao
{
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Vehicle vehicle)
    {
        entityManager.persist(vehicle);
    }

    public Vehicle getById(int id)
    {
        return entityManager.find(Vehicle.class, id);
    }

    public void delete(Vehicle vehicle)
    {
        if(entityManager.contains(vehicle))
        {
            entityManager.remove(vehicle);
        }
        else
        {
            entityManager.remove(entityManager.merge(vehicle));
        }
    }

    public void update(Vehicle vehicle)
    {
        Vehicle oldVehicle = entityManager.find(Vehicle.class, vehicle.getID());
        if(entityManager.contains(oldVehicle))
        {
            entityManager.merge(vehicle);
        }
        else
        {
            entityManager.persist(vehicle);
        }
    }



}
