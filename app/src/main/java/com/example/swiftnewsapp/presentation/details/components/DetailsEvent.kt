package com.example.swiftnewsapp.presentation.details.components

import com.example.swiftnewsapp.domain.model.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemovingSideEffect : DetailsEvent()
}