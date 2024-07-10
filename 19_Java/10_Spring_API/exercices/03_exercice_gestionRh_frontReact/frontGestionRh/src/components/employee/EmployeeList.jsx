import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchAllEmployee } from './employeeSlice';
import EmployeeDetail from './EmployeeDetail';

const EmployeeList = () => {

    const dispatch = useDispatch();
    const employees = useSelector((state) => state.employee.employees)
    const isPending = useSelector((state) => state.employee.isPending)

    useEffect(() => {
        dispatch(fetchAllEmployee())
        console.log(employees);
    }, [])


    return (
        <>
        {isPending && ( <h3>Chargement en cours ...</h3>)}

        {employees.length && (
            <main className='container'>
                <section>
                    {employees.map((employee, index) => (
                        <EmployeeDetail key={index} employee={employee} />
                    ))}
                </section>
            </main>
        )}
        </>
    );
}

export default EmployeeList;
