package com.nikolaej.cacademy.util

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.runtime.Composable
import com.nikolaej.cacademy.R

@Composable
fun Sound(mContext: Context, muzFile: Int){
    val mMediaPlayer = MediaPlayer.create(mContext, muzFile)
    mMediaPlayer.start()
}