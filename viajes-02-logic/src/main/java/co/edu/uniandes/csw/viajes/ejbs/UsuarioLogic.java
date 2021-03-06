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
package co.edu.uniandes.csw.viajes.ejbs;

import co.edu.uniandes.csw.viajes.entities.UsuarioEntity;
import co.edu.uniandes.csw.viajes.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viajes.persistence.UsuarioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author n.aguilar
 */
@Stateless
public class UsuarioLogic {

    /**
     * La persistencia de la entidad usuario
     */
    @Inject
    private UsuarioPersistence persistence;

    /**
     * Retorna los usuarios en el sistema
     *
     * @return Lista de usuarios en el sistema
     */
    public List<UsuarioEntity> getUsuarios() {
        return persistence.findAll();
    }

    /**
     * Retorna un usuario que se identifique con el parametro
     *
     * @param id El id de la entidad que se busca
     * @return El usuario que se esta buscando
     * @throws BusinessLogicException en caso de que no exista un usuario
     * identificado con el id
     */
    public UsuarioEntity getUsuario(Long id) throws BusinessLogicException {
        UsuarioEntity u = persistence.find(id);
        if (u == null) {
            throw new BusinessLogicException("El usuario que se busca no existe");
        }
        return u;
    }

    /**
     * Crea un usuario con la entidad que llega por parametro
     *
     * @param entity La entidad que se desea crear
     * @return La entidad que se creo
     * @throws BusinessLogicException En caso de que el genero de la entidad no
     * sea un valor esperado
     */
    public UsuarioEntity createUsuario(UsuarioEntity entity) throws BusinessLogicException {
        if (!entity.getGenero().equalsIgnoreCase("masculino") && !entity.getGenero().equalsIgnoreCase("femenino")) {
            throw new BusinessLogicException("El genero del usuario a crear no es valido. (Debe ser masculino o femenino)");
        }
        persistence.create(entity);
        return entity;
    }

    /**
     * Actualiza una entidad que llega por parametro
     *
     * @param entity La entidad que se desea actualizar
     * @return La entidad actualizada
     */
    public UsuarioEntity updateUsuario(UsuarioEntity entity) throws BusinessLogicException {
        if (!entity.getGenero().equalsIgnoreCase("masculino") && !entity.getGenero().equalsIgnoreCase("femenino")) {
            throw new BusinessLogicException("El genero del usuario a crear no es valido. (Debe ser masculino o femenino)");
        }
        if (getUsuario(entity.getId()) == null) {
            throw new BusinessLogicException("El usuario que se desea actualizar no existe");
        }
        entity = persistence.update(entity);

        return entity;
    }

    /**
     * Elimina una entidad identificada con el id que llega por parametro
     *
     * @param id el id de la entidad a eliminar
     */
    public void deleteUsuario(Long id) {
        persistence.delete(id);
    }
}
