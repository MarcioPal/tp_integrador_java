/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import java.util.List;


public interface IRepository<T> {
    T findById(Long id);
    List<T> findAll();
    void save(T obj);
    void update(T obj);
    void delete(T obj);
}
