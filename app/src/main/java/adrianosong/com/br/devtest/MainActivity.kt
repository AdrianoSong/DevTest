package adrianosong.com.br.devtest

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.button_content.view.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.webview_content.view.*
import android.content.DialogInterface
import android.content.DialogInterface.BUTTON_NEUTRAL
import android.support.v7.app.AlertDialog


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


        setupViews()

    }

    override fun onResume() {
        super.onResume()

        myWebViewContainer.visibility = View.VISIBLE
        myButtonContainer.visibility = View.INVISIBLE
        myGithubListContainer.visibility = View.INVISIBLE
    }

    private fun setupViews() {

        myWebViewContainer.myWebViewContent.loadUrl("www.google.com")

        myButtonContainer.dialogButton.setOnClickListener({

            val alertDialog = AlertDialog.Builder(this@MainActivity).create()
            alertDialog.setTitle("Alert")
            alertDialog.setMessage("Alert message to be shown")
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
            alertDialog.show()

        })

        myButtonContainer.toastButton.setOnClickListener({
            Toast.makeText(applicationContext, "Hello toast", Toast.LENGTH_SHORT).show()
        })

    }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
                myWebViewContainer.visibility = View.VISIBLE
                myButtonContainer.visibility = View.INVISIBLE
                myGithubListContainer.visibility = View.INVISIBLE
            }
            R.id.nav_gallery -> {
                myWebViewContainer.visibility = View.INVISIBLE
                myButtonContainer.visibility = View.VISIBLE
                myGithubListContainer.visibility = View.INVISIBLE

            }
            R.id.nav_slideshow -> {

                myWebViewContainer.visibility = View.INVISIBLE
                myButtonContainer.visibility = View.INVISIBLE
                myGithubListContainer.visibility = View.VISIBLE

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
