package com.example.mvvm.ui.fragment.home.profile.updateprofile

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mvvm.NavGraphDirections
import com.example.mvvm.R
import com.example.mvvm.data.ApiInterface
import com.example.mvvm.data.body.UpdateInforBody
import com.example.mvvm.data.response.AvatarResponse
import com.example.mvvm.data.response.UpdateInforResponse
import com.example.mvvm.databinding.FragmentProfileUpdateinforBinding
import com.example.mvvm.module.UpdateInforChange
import com.example.mvvm.module.UserInformation
import com.example.mvvm.ui.basefragment.BaseFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_profile_updateinfor.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import pl.aprilapps.easyphotopicker.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class UpdateProfileFragment : BaseFragment<FragmentProfileUpdateinforBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_profile_updateinfor
    var easyimage: EasyImage? = null
    lateinit var image_filesrc: MediaFile
    private val updateProfileVM: UpdateProfileViewModel by viewModels()

    override fun initView() {
        goBack()
        setInfor()
        setChangeAvatar()
        changeBirthday()
        changeGender()
        submitUpdate()
    }

    private fun changeGender() {
        val setGenderFrag = SetGenderBottomSheetFrag(object : UpdateInforChange {
            override fun getBirthday(year: Int, month: Int, day: Int) {
            }

            override fun getGender(gender: Int) {
                if (gender == 0) {
                    txtgender.text = "Female"
                } else {
                    txtgender.text = "Male"
                }
            }

            override fun choosePicture(choosen: Int) {
            }
        })
        binding!!.txtgender.setOnClickListener {
            setGenderFrag.show(this.requireActivity().supportFragmentManager, "BottomSheetDialog")
        }
    }

    private fun changeBirthday() {
        val datepicker = DatepickerFrag(object : UpdateInforChange {
            @SuppressLint("SetTextI18n")
            override fun getBirthday(year: Int, month: Int, day: Int) {
                binding!!.birthday.text = day.toString() + "-" + month + "-" + year
            }

            override fun getGender(gender: Int) {

            }

            override fun choosePicture(choosen: Int) {

            }
        })

        binding!!.birthday.setOnClickListener {
            datepicker.show(this.requireActivity().supportFragmentManager, "datepicker")
        }
    }

    private fun setInfor() {
        Picasso.get().load(UserInformation.avatar).error(R.drawable.avatar).centerCrop().fit()
            .into(binding!!.avatar)
        binding!!.name.text = UserInformation.fullname
        binding!!.fullname.setText(UserInformation.fullname)
        binding!!.birthday.text = (UserInformation.birthday)
        binding!!.txtgender.text = (UserInformation.sexual)
        binding!!.address.setText(UserInformation.address)
        binding!!.phone.setText(UserInformation.phoneNumber)
        binding!!.email.setText(UserInformation.email)
    }

    private fun setChangeAvatar() {
        easyimage = this.activity?.let {
            EasyImage.Builder(it).setChooserTitle("Pick Media")
                .setCopyImagesToPublicGalleryFolder(true)
                .setChooserType(ChooserType.CAMERA_AND_GALLERY)
                .setFolderName("EasyImage sample")
                .allowMultiple(false)
                .build()
        }
        binding!!.setavatar.setOnClickListener {

            val setAvatarBottomSheetFrag = SetAvatarBottomSheetFrag(object : UpdateInforChange {
                override fun getBirthday(year: Int, month: Int, day: Int) {
                }

                override fun getGender(gender: Int) {
                }

                override fun choosePicture(choosen: Int) {
                    if (choosen == 0) easyimage?.openGallery(this@UpdateProfileFragment)
                    else easyimage?.openCameraForImage(this@UpdateProfileFragment)
                }
            })
            setAvatarBottomSheetFrag.show(
                this.requireActivity().supportFragmentManager,
                "BottomSheetDialog"
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        easyimage?.handleActivityResult(
            requestCode,
            resultCode,
            data,
            this.requireActivity(),
            object : DefaultCallback() {

                override fun onMediaFilesPicked(imageFiles: Array<MediaFile>, source: MediaSource) {
                    Log.e("EasyImage", "Image file returned: $imageFiles")

                    var imagefile: MediaFile = imageFiles.get(imageFiles.size - 1)
                    image_filesrc = imagefile
                    Picasso.get().load(image_filesrc.file).fit().centerCrop().into(avatar)

                    val file: File = image_filesrc.file
                    val requestBody = RequestBody.create("image/*".toMediaTypeOrNull(), file)
                    val body =
                        MultipartBody.Part.createFormData("File", file.getName(), requestBody)

                    val setavatar = ApiInterface.create().setAvatar(body)
                    setavatar.enqueue(object : Callback<AvatarResponse> {
                        override fun onResponse(
                            call: Call<AvatarResponse>,
                            response: Response<AvatarResponse>
                        ) {
                            UserInformation.avatar = response.body()?.data.toString().trim()
                            Log.e("ok", "after change: " + UserInformation.avatar)
                        }

                        override fun onFailure(call: Call<AvatarResponse>, t: Throwable) {
                            Log.e("ok", t.toString())
                            //Log.e("ok","before change: "+image_url)
                            Toast.makeText(requireContext(), "tach", Toast.LENGTH_LONG).show()
                        }
                    })
                }

                override fun onImagePickerError(error: Throwable, source: MediaSource) {
                    error.printStackTrace()
                }

                override fun onCanceled(source: MediaSource) {
                }
            })
    }

    private fun submitUpdate() {
        binding!!.submit.setOnClickListener {
            if (fullname.text.isEmpty() || fullname.text.contains("^[A-Za-z][A-Za-z0-9_]{7,29}$")) {
                fullname.error = "Invalid"
                return@setOnClickListener
            }
            if (phone.text.toString().length != 10) {
                phone.error = "Invalid"
                return@setOnClickListener

            }
            if (address.text.toString().isEmpty()) {
                address.error = "Invalid"
                return@setOnClickListener

            }
            if (email.text.toString()
                    .isEmpty() || !email.text.contains("@") || !email.text.contains(".com")
            ) {
                email.error = "Invalid"
                return@setOnClickListener

            }

            val changeInfor = ApiInterface.create().updateInfor(
                UpdateInforBody(
                    address.text.toString(),
                    UserInformation.avatar!!,
                    birthday.text.toString(),
                    fullname.text.toString(),
                    if (txtgender.text == "Female") 0 else 1,
                    phone.text.toString(),
                    email.text.toString()
                )
            )

            changeInfor.enqueue(object : Callback<UpdateInforResponse> {
                override fun onResponse(
                    call: Call<UpdateInforResponse>,
                    response: Response<UpdateInforResponse>
                ) {
                    name.text = response.body()?.data?.fullName.toString().trim()
                    UserInformation.fullname = fullname.text.toString()
                    UserInformation.birthday = birthday.text.toString()
                    UserInformation.address = address.text.toString()
                    UserInformation.phoneNumber = phone.text.toString()
                    UserInformation.email = email.text.toString()
                    Toast.makeText(requireActivity(), "Success", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<UpdateInforResponse>, t: Throwable) {
                    Toast.makeText(requireActivity(), t.toString(), Toast.LENGTH_SHORT).show()
                }

            })
        }
    }

    private fun goBack() {
        binding!!.updateBack.setOnClickListener {
            findNavController().navigate(NavGraphDirections.actionToProfile())
        }
    }
}