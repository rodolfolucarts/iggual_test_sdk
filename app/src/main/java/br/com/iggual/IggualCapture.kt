package br.com.iggual

import android.content.Context
import android.content.Intent
import br.com.iggual.activities.IggualFingerActivity
import br.com.iggual.IggualCapture

class IggualCapture {

    var syncBlock = false;

    fun capture(context: Context) : Boolean {


        var intent = Intent(context, IggualFingerActivity::class.java);
        context.startActivity(intent);

        return false;
    }



}