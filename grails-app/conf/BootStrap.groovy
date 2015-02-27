import products.Role
import products.User
import products.UserRole;

class BootStrap {

    def init = { servletContext ->
		println("Starting Bootstrap..")
		if (User.count() == 0) {
			def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush:true, failOnError:true)
			def adminUser = new User(username:'admin',password:'admin',initials:'ADM',email:'varuzza@gmail.com')
			adminUser.save(flush:true)
			UserRole.create(adminUser,adminRole,true)
			//.save(flush:true, failOnError:true)
		} else {
			println "Nothing to do"
		}
		println("Finished Bootstrap")
    }
    def destroy = {
    }
}
