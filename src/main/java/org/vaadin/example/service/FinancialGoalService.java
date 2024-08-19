package org.vaadin.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.example.model.FinancialGoal;
import org.vaadin.example.repository.FinancialGoalRepository;

import java.util.List;

/**
 * Service class for managing financial goal-related operations.
 * This class interacts with the {@link FinancialGoalRepository} to perform CRUD operations on {@link FinancialGoal} entities.
 */
@Service
public class FinancialGoalService {

    @Autowired
    private FinancialGoalRepository financialGoalRepository;

    /**
     * Retrieves a list of financial goals associated with a specific user ID.
     *
     * @param userId the ID of the user whose financial goals are to be retrieved
     * @return a list of financial goals associated with the specified user ID
     */
    public List<FinancialGoal> getFinancialGoalsByUserId(Long userId) {
        return financialGoalRepository.findByUserId(userId);
    }

    /**
     * Adds a new financial goal to the repository.
     *
     * @param financialGoal the financial goal object to be added
     * @return the newly added financial goal object
     */
    public FinancialGoal addFinancialGoal(FinancialGoal financialGoal) {
        return financialGoalRepository.save(financialGoal);
    }

    /**
     * Finds a financial goal by its ID.
     *
     * @param id the ID of the financial goal to find
     * @return the financial goal object if found, or null if not found
     */
    public FinancialGoal findFinancialGoalById(Long id) {
        return financialGoalRepository.findById(id).orElse(null);
    }

    /**
     * Deletes a financial goal by its ID.
     *
     * @param id the ID of the financial goal to be deleted
     */
    public void deleteFinancialGoal(Long id) {
        financialGoalRepository.deleteById(id);
    }
}
