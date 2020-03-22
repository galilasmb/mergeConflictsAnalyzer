package mergeConflictsAnalyzer.ufpe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.revwalk.RevCommit;

import com.google.common.collect.Lists;

/**
 * @author Galileu Santos
 *
 */
public class Main {
	List<String> saida = new ArrayList<String>();
	public static String RAMIFICATION = "master";
	static Git git;
	public static Project project;


	public Main() {
	}

	public static void main(String[] args) {
		inicializar();
		
	}
	
	
	public static void inicializar() {
		project = new Project("https://github.com/libexpat/libexpat.git", "Expat", "C:\\Expat");
		Iterable<RevCommit> commits = getCommits();
		List<RevCommit> commitsList = Lists.newArrayList(commits);
		for (int i = 0; i < 100; i++) {
				System.out.println("Log do commit atual:.");
				RevCommit commit = (RevCommit) commitsList.get(i);
				System.out.println(commit.getName());
				System.out.println("Commit atual = " + i);
		}
	}

	public static Iterable<RevCommit> getCommits() {
        
		try {
			File folder = new File(project.getPath());
	
			if (folder.exists()){
				FileUtils.deleteDirectory(new File(project.getPath()));
			}

			git = Git.cloneRepository().setURI(project.getLinkGit()).setDirectory(folder).call();
			String treeName = "refs/heads/" + RAMIFICATION; // tag or branch
			return git.log().add(git.getRepository().resolve(treeName)).call();
		} catch (InvalidRemoteException e) {
			e.printStackTrace();
		} catch (TransportException e) {
			e.printStackTrace();
		} catch (GitAPIException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}