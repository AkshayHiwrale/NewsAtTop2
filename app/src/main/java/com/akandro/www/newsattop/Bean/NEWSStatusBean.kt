package com.akandro.www.newsattop.Bean

data class NEWSStatusBean(
        var status: String,
        var totalResults: Int,
        var articles: List<Article>
)