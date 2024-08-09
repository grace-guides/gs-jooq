package grace.guides

class PostController {
    def postService

    def index() {
        [postList: this.postService.list()]
    }

}
