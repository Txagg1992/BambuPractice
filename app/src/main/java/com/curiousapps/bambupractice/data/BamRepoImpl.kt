package com.curiousapps.bambupractice.data

import com.curiousapps.bambupractice.domain.BamItem
import com.curiousapps.bambupractice.domain.BamRepo
import com.curiousapps.bambupractice.network.BamApi
import okio.IOException
import javax.inject.Inject

class BamRepoImpl @Inject constructor(
    private val api: BamApi
) : BamRepo {

    override suspend fun fetchBamList(): Result<List<BamItem>> {
        try {
            api.fetchBamList().let {
                return Result.success(it)
            }

        }catch (e:IOException){
            return Result.failure(e)
        }
    }
}