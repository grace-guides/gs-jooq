package grace.guides

import grace.guides.db.Tables
import org.jooq.DSLContext

class PostService {

    DSLContext dslContext

    def list() {
        this.dslContext.selectFrom(Tables.POSTS).asList()
    }
}
