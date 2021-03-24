package com.radian.myradianvaluations.view.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.Assets
import com.radian.myradianvaluations.Response.Categories
import com.radian.myradianvaluations.adapter.AssetsAdapter
import com.radian.myradianvaluations.adapter.CategoriesAdapter
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.CameraActivity
import kotlinx.android.synthetic.main.fragment_all_sub_photos.view.*


class AllAndSubPhotosFragment : Fragment() {
    internal lateinit var view: View
    private lateinit var adapterCategories: CategoriesAdapter
    private var listCategories: ArrayList<Categories> = ArrayList()
    private var currentCategoryPosition: Int = -1
    private var pickImage = 100
    private lateinit var imageUri: Uri
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_all_sub_photos, container, false)
        addListItems()
        setRecyclerView()
        return view
    }

    private fun addListItems() {
        listCategories.add(Categories("Living Room", null, "", 0.0, 0.0))
        listCategories.add(Categories("Bed Room", null, "", 0.0, 0.0))
        listCategories.add(Categories("Bath Room", null, "", 0.0, 0.0))
        listCategories.add(Categories("Terrace Room", null, "", 0.0, 0.0))
        listCategories.add(Categories("Living Room", null, "", 0.0, 0.0))
        listCategories.add(Categories("Bed Room", null, "", 0.0, 0.0))
        listCategories.add(Categories("Bath Room", null, "", 0.0, 0.0))
        listCategories.add(Categories("Terrace Room", null, "", 0.0, 0.0))
    }

    private fun setRecyclerView() {
        adapterCategories = CategoriesAdapter(context!!, listCategories, {
            currentCategoryPosition = it as Int
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }, {
            currentCategoryPosition = it as Int
            val intent = Intent(context, CameraActivity::class.java)
            intent.putExtra(Const.INTENT_POSITION_KEY, currentCategoryPosition)
            startActivity(intent)
        }, {
            currentCategoryPosition = it as Int
            var category = listCategories[currentCategoryPosition].name
            val builder = AlertDialog.Builder(context!!)
            builder.setTitle(getString(R.string.app_name))
            builder.setMessage("Are you sure you want to delete $category Image?")

            builder.setPositiveButton("Yes") { _, _ ->
                listCategories[currentCategoryPosition].imageUri = ""
                Pref.setCategoriesArrayList(
                    context!!,
                    Const.CATEGORIES_SHARED_PREF_KEY,
                    listCategories
                )
                adapterCategories.notifyItemChanged(currentCategoryPosition)
            }

            builder.setNegativeButton(android.R.string.no) { dialog, _ ->
                dialog.dismiss()
            }
            builder.show()
        })

        view.rvCategories.layoutManager = GridLayoutManager(context, 2)
        view.rvCategories.adapter = adapterCategories
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data!!
            listCategories[currentCategoryPosition].imageUri = imageUri.toString()
            Pref.setCategoriesArrayList(context!!, Const.CATEGORIES_SHARED_PREF_KEY, listCategories)
            listCategories =
                Pref.getCategoriesArrayList(context!!, Const.CATEGORIES_SHARED_PREF_KEY, "")
            adapterCategories.notifyItemChanged(currentCategoryPosition)
        }
    }

}