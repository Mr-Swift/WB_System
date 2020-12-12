package com.apple.developer.dao;

@SuppressWarnings("all")
public interface IHolidayDao<T> {
    public T selectHolidays();

    public T selectByHolNo();

    public T selectByEmpNo();

    public T selectByType();

    public T selectByStatus();

    public T selectByEmpNoAndType();

    public T selectByEmpNoAndStatus();

    public T selectByTypeAndStatus();

    public T selectEmpNoAndTypeAndStatus();

    public T insertHoliday();

    public T updateByHolNo();

    public T deleteByHolNo();

}
