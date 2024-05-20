package com.example.custombuttombar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Number of selected tab. We have 4 tabs so value must lie between 1-4. Default value is 1 because first tab is
    private var selectedTab = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeLayout = findViewById<LinearLayout>(R.id.homeLayout)
        val likeLayout = findViewById<LinearLayout>(R.id.likeLayout)
        val notificationLayout = findViewById<LinearLayout>(R.id.notificationLayout)
        val profileLayout = findViewById<LinearLayout>(R.id.profileLayout)

        val homeImage = findViewById<ImageView>(R.id.homeImage)
        val likeImage = findViewById<ImageView>(R.id.likeImage)
        val notificationImage = findViewById<ImageView>(R.id.notificationImage)
        val profileImage = findViewById<ImageView>(R.id.profileImage)

        val homeTxt = findViewById<TextView>(R.id.homeTxt)
        val likeTxt = findViewById<TextView>(R.id.likeTxt)
        val notificationTxt = findViewById<TextView>(R.id.notificationTxt)
        val profileTxt = findViewById<TextView>(R.id.profileTxt)

        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentContainer, HomeFragment::class.java, null)
            .commit()


        homeLayout.setOnClickListener {
            // Check if home is already selected or not.
            if (selectedTab != 1) {

                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, HomeFragment::class.java, null)
                    .commit()


                // Unselect other tabs except home tab
                likeTxt.visibility = View.GONE
                notificationTxt.visibility = View.GONE
                profileTxt.visibility = View.GONE

                likeImage.setImageResource(R.drawable.like_icon)
                notificationImage.setImageResource(R.drawable.notifications_icon)
                profileImage.setImageResource(R.drawable.profile_icon)

                likeLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                notificationLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                profileLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))

                // Select home tab
                homeTxt.visibility = View.VISIBLE
                homeImage.setImageResource(R.drawable.home_selected_icon)
                homeLayout.setBackgroundResource(R.drawable.round_back_home_100)

                // Create animation
                val scaleAnimation = ScaleAnimation(
                    0.8f, 1.0f, 0.8f, 1.0f,
                    Animation.RELATIVE_TO_SELF, 0.5f, //probablemente tiene que estar en 0
                    Animation.RELATIVE_TO_SELF, 0.5f
                )
                scaleAnimation.duration = 200
                scaleAnimation.fillAfter = true
                homeLayout.startAnimation(scaleAnimation)

                // Set tab as selected
                selectedTab = 1
            }
        }

        likeLayout.setOnClickListener {
            // Check if like tab is already selected or not.
            if (selectedTab != 2) {

                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, LikesFragments::class.java, null)
                    .commit()


                // Unselect other tabs except like tab
                homeTxt.visibility = View.GONE
                notificationTxt.visibility = View.GONE
                profileTxt.visibility = View.GONE

                homeImage.setImageResource(R.drawable.home_icon)
                notificationImage.setImageResource(R.drawable.notifications_icon)
                profileImage.setImageResource(R.drawable.profile_icon)

                homeLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                notificationLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                profileLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))

                // Select home tab
                likeTxt.visibility = View.VISIBLE
                likeImage.setImageResource(R.drawable.like_selected_icon)
                likeLayout.setBackgroundResource(R.drawable.round_back_like_100)

                // Create animation
                val scaleAnimation = ScaleAnimation(
                    0.8f, 1.0f, 0.8f, 1.0f,
                    Animation.RELATIVE_TO_SELF, 1.0f,
                    Animation.RELATIVE_TO_SELF, 0.5f
                )
                scaleAnimation.duration = 200
                scaleAnimation.fillAfter = true
                likeLayout.startAnimation(scaleAnimation)

                // Set tab as selected
                selectedTab = 2
            }
        }

        notificationLayout.setOnClickListener {
            // Check if notification tab is already selected or not.
            if (selectedTab != 3) {

                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, NotificationFragment::class.java, null)
                    .commit()


                // Unselect other tabs except notification tab
                homeTxt.visibility = View.GONE
                likeTxt.visibility = View.GONE
                profileTxt.visibility = View.GONE

                homeImage.setImageResource(R.drawable.home_icon)
                likeImage.setImageResource(R.drawable.like_icon)
                profileImage.setImageResource(R.drawable.profile_icon)

                homeLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                likeLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                profileLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))

                // Select notification tab
                notificationTxt.visibility = View.VISIBLE
                notificationImage.setImageResource(R.drawable.notifications_selected_icon)
                notificationLayout.setBackgroundResource(R.drawable.round_back_notification_100)

                // Create animation
                val scaleAnimation = ScaleAnimation(
                    0.8f, 1.0f, 0.8f, 1.0f,
                    Animation.RELATIVE_TO_SELF, 1.0f,
                    Animation.RELATIVE_TO_SELF, 0.5f
                )
                scaleAnimation.duration = 200
                scaleAnimation.fillAfter = true
                notificationLayout.startAnimation(scaleAnimation)

                // Set tab as selected
                selectedTab = 3
            }
        }

        profileLayout.setOnClickListener {
            // Check if profile tab is already selected or not.
            if (selectedTab != 4) {

                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, ProfileFragment::class.java, null)
                    .commit()

                // Unselect other tabs except profile tab
                homeTxt.visibility = View.GONE
                likeTxt.visibility = View.GONE
                notificationTxt.visibility = View.GONE

                homeImage.setImageResource(R.drawable.home_icon)
                likeImage.setImageResource(R.drawable.like_icon)
                notificationImage.setImageResource(R.drawable.notifications_icon)

                homeLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                likeLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                notificationLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))

                // Select notification tab
                profileTxt.visibility = View.VISIBLE
                profileImage.setImageResource(R.drawable.profile_selected_icon)
                profileLayout.setBackgroundResource(R.drawable.round_back_profile_100)

                // Create animation
                val scaleAnimation = ScaleAnimation(
                    0.8f, 1.0f, 0.8f, 1.0f,
                    Animation.RELATIVE_TO_SELF, 1.0f,
                    Animation.RELATIVE_TO_SELF, 0.5f
                )
                scaleAnimation.duration = 200
                scaleAnimation.fillAfter = true
                profileLayout.startAnimation(scaleAnimation)

                // Set tab as selected
                selectedTab = 4
            }
        }

    }
}