package ru.lavrov.tm.command.general;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.lavrov.tm.command.AbstractCommand;
import ru.lavrov.tm.entity.User;
import ru.lavrov.tm.enumerate.Role;

import java.util.Arrays;
import java.util.Collection;

//public class JAXBLoadСommand extends AbstractCommand {
//    private static final boolean SAFE = true;
//    @Nullable
//    private static final Collection<Role> ROLES = Arrays.asList(Role.ADMIN, Role.USER);
//    @NotNull
//    private static final String COMMAND = "serialize";
//    @NotNull
//    private static final String DESCRIPTION = "Serialize data.";
//
//    @NotNull
//    @Override
//    public String getCommand() {
//        return COMMAND;
//    }
//
//    @NotNull
//    @Override
//    public String getDescription() {
//        return DESCRIPTION;
//    }
//
//    @Override
//    public void execute() throws Exception {
//        JAXBContext context = JAXBContext.newInstance(User.class);
//        User user = (User) context.createUnmarshaller().unmarshal(new File("src/main/file/users.xml"));
//        System.out.println(user);
//
//    }
//
//    @Override
//    public boolean isSafe() {
//        return SAFE;
//    }
//
//    @Nullable
//    @Override
//    public Collection<Role> getRoles() {
//        return ROLES;
//    }
//}
