package com.curiousapps.bambupractice.domain

interface BamRepo {

    suspend fun fetchBamList(): Result<List<BamItem>>
}