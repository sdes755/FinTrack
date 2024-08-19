package org.vaadin.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.example.model.Budget;
import org.vaadin.example.repository.BudgetRepository;

import java.util.List;

/**
 * Service class for managing budget-related operations.
 * This class interacts with the {@link BudgetRepository} to perform CRUD operations on {@link Budget} entities.
 */
@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    /**
     * Retrieves a list of budgets associated with a specific user ID.
     *
     * @param userId the ID of the user whose budgets are to be retrieved
     * @return a list of budgets associated with the specified user ID
     */
    public List<Budget> getBudgetsByUserId(Long userId) {
        return budgetRepository.findByUserId(userId);
    }

    /**
     * Adds a new budget to the repository.
     *
     * @param budget the budget object to be added
     * @return the newly added budget object
     */
    public Budget addBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    /**
     * Finds a budget by its ID.
     *
     * @param id the ID of the budget to find
     * @return the budget object if found, or null if not found
     */
    public Budget findBudgetById(Long id) {
        return budgetRepository.findById(id).orElse(null);
    }

    /**
     * Deletes a budget by its ID.
     *
     * @param id the ID of the budget to be deleted
     */
    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }
}
