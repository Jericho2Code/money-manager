package com.jericho2code.app_finance_manager.screens.add_edit_category

import android.arch.lifecycle.MutableLiveData
import com.jericho2code.app_finance_manager.model.entity.Category
import com.jericho2code.app_finance_manager.model.repositories.CategoryRepository
import com.jericho2code.app_finance_manager.utils.CorutineViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddEditCategoryViewModel : CorutineViewModel() {

    @Inject
    lateinit var categoryRepository: CategoryRepository


    var backgroundColorLiveData = MutableLiveData<Int>()
    var iconIdLiveData = MutableLiveData<Int>()

    fun setBackgroundColor(color: Int?) {
        backgroundColorLiveData.postValue(color)
    }

    fun setIconId(id: Int?) {
        iconIdLiveData.postValue(id)
    }

    fun saveCategory(category: Category) {
        scope.launch {
            categoryRepository.saveCategory(category)
        }
    }


}