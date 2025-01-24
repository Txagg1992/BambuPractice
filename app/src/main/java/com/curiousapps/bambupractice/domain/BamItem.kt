package com.curiousapps.bambupractice.domain


import com.google.gson.annotations.SerializedName

data class BamItem(
    @SerializedName("deepLinkURL")
    var deepLinkURL: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("isVisible")
    var isVisible: Boolean,
    @SerializedName("subtitle")
    var subtitle: String,
    @SerializedName("title")
    var title: String
)