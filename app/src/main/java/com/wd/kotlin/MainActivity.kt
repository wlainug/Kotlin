package com.wd.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(), View.OnClickListener ,Contract.ILoginView{


    override fun success(userBean: UserBean) {
        Toast.makeText(this, userBean.result.phone, Toast.LENGTH_SHORT).show()
    }

    override fun failed(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }


    lateinit var loginPresenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()

    }
    private fun initData() {
        loginPresenter = Presenter()
    }

    private fun initView() {
        btn_main_login.setOnClickListener(this)
        
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_main_login -> login()
        }
    }


    fun login(){
        loginPresenter.attach(this)
        var params = HashMap<String,String>()
        val userName = et_main_name.text.toString()
        val userPaw = et_main_pwd.text.toString()
        if(userName!=null||!userName.equals("") && userPaw!=null||!userPaw.equals("")){
            params.put("phone",userName)
            params.put("pwd",userPaw)
            loginPresenter.login(params,this)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        if(loginPresenter!=null){
            loginPresenter.detach()
        }
    }

}
