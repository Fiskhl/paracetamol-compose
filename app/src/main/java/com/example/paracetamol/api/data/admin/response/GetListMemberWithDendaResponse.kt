package com.example.paracetamol.api.data.admin.response

/**
 * Data class representing the response for getting a list of members with associated fines.
 * @property status The HTTP status code of the response.
 * @property message A descriptive message accompanying the response.
 * @property data The data containing a list of [MemberWithDenda].
 */
data class GetListMemberWithDendaResponse(
    val status: Int,
    val message: String,
    val data: GetListMemberWithDendaResponseData
)

/**
 * Data class representing the data structure for the response.
 * @property members The list of members with associated fines.
 */
data class GetListMemberWithDendaResponseData(
    val members: List<MemberWithDenda>
)

/**
 * Data class representing detailed information about a member with associated fine.
 * @property id The unique identifier of the member.
 * @property name The name of the member.
 * @property nominal The amount of the fine associated with the member.
 */
data class MemberWithDenda(
    val id: String,
    val name: String,
    val nominal: Int
)