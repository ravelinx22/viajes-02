/* 
 * The MIT License
 *
 * Copyright 2017 wr.ravelo.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.ReservaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

/**
 *
 * @author ja.bermudez10
 */
@Stateless
public class ReservaPersistence
{

    @PersistenceContext(unitName = "viajesPU")
    protected EntityManager entityManager;

    public ReservaEntity create(ReservaEntity reservaEntity)
    {
        entityManager.persist(reservaEntity);
        return reservaEntity;
    }

    public void delete(Long idViajero, Long id)
    {
        TypedQuery<ReservaEntity> query = entityManager.createQuery("Select u from ReservaEntity u where u.viajero.id = :idViajero and u.id = :id", ReservaEntity.class);
        query = query.setParameter("idViajero", idViajero);
        query = query.setParameter("idReserva", id);
        ReservaEntity reservaToDelete = query.getSingleResult();
        entityManager.remove(reservaToDelete);
    }

    public ReservaEntity update(ReservaEntity reservaEntity)
    {
        return entityManager.merge(reservaEntity);
    }

    public List<ReservaEntity> findReservasByIdViajero(Long idViajero)
    {
        TypedQuery<ReservaEntity> query = entityManager.createQuery("Select u from ReservaEntity u where u.viajero.id =" + idViajero, ReservaEntity.class);
        List<ReservaEntity> reservasPorIdViajero = query.getResultList();
        
        if (!reservasPorIdViajero.isEmpty())
            return reservasPorIdViajero;
        else
            return null;
    }

    public ReservaEntity findReserva(Long id) {
        return entityManager.find(ReservaEntity.class, id);
    }
    
}
